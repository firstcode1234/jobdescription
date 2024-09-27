<template>
    <v-card style="width:450px; height:100%;" outlined>
        <template slot="progress">
            <v-progress-linear
                    color="primary-darker-1"
                    height="10"
                    indeterminate
            ></v-progress-linear>
        </template>

        <v-card-title v-if="value._links">
            Jobdescription # {{decode(value._links.self.href.split("/")[value._links.self.href.split("/").length - 1])}}
        </v-card-title >
        <v-card-title v-else>
            Jobdescription
        </v-card-title >        

        <v-card-text style="background-color: white;">
            <String label="Jobname" v-model="value.jobname" :editMode="editMode" :inputUI="''"/>
            <String label="JobDescription" v-model="value.jobDescription" :editMode="editMode" :inputUI="''"/>
            <String label="Qualifications" v-model="value.qualifications" :editMode="editMode" :inputUI="''"/>
            <String label="Education" v-model="value.education" :editMode="editMode" :inputUI="''"/>
            <String label="CompletionEducation" v-model="value.completionEducation" :editMode="editMode" :inputUI="''"/>
        </v-card-text>

        <v-card-actions style="background-color: white;">
            <v-spacer></v-spacer>
            <v-btn
                color="primary"
                text
                @click="edit"
                v-if="!editMode"
            >
                수정
            </v-btn>
            <div v-else>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                저장
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
                >
                    삭제
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode && !isNew"
                >
                    취소
                </v-btn>
            </div>
        </v-card-actions>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openEnter"
            >
                Enter
            </v-btn>
            <v-dialog v-model="enterDiagram" width="500">
                <EnterCommand
                    @closeDialog="closeEnter"
                    @enter="enter"
                ></EnterCommand>
            </v-dialog>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openModify"
            >
                Modify
            </v-btn>
            <v-dialog v-model="modifyDiagram" width="500">
                <ModifyCommand
                    @closeDialog="closeModify"
                    @modify="modify"
                ></ModifyCommand>
            </v-dialog>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openDelete"
            >
                Delete
            </v-btn>
            <v-dialog v-model="deleteDiagram" width="500">
                <DeleteCommand
                    @closeDialog="closeDelete"
                    @delete="delete"
                ></DeleteCommand>
            </v-dialog>
        </v-card-actions>

        <v-snackbar
            v-model="snackbar.status"
            :top="true"
            :timeout="snackbar.timeout"
            color="error"
        >
            {{ snackbar.text }}
            <v-btn dark text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
    </v-card>

</template>

<script>
    const axios = require('axios').default;


    export default {
        name: 'AllDepartmentsJobdescription',
        components:{
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
        },
        data: () => ({
            snackbar: {
                status: false,
                timeout: 5000,
                text: '',
            },
            enterDiagram: false,
            modifyDiagram: false,
            deleteDiagram: false,
        }),
	async created() {
        },
        methods: {
            decode(value) {
                return decodeURIComponent(value);
            },
            selectFile(){
                if(this.editMode == false) {
                    return false;
                }
                var me = this
                var input = document.createElement("input");
                input.type = "file";
                input.accept = "image/*";
                input.id = "uploadInput";
                
                input.click();
                input.onchange = function (event) {
                    var file = event.target.files[0]
                    var reader = new FileReader();

                    reader.onload = function () {
                        var result = reader.result;
                        me.imageUrl = result;
                        me.value.photo = result;
                        
                    };
                    reader.readAsDataURL( file );
                };
            },
            edit() {
                this.editMode = true;
            },
            async save(){
                try {
                    var temp = null;

                    if(!this.offline) {
                        if(this.isNew) {
                            temp = await axios.post(axios.fixUrl('/jobdescriptions'), this.value)
                        } else {
                            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
                        }
                    }

                    if(this.value!=null) {
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    } else {
                        this.value = temp.data;
                    }

                    this.editMode = false;
                    this.$emit('input', this.value);

                    if (this.isNew) {
                        this.$emit('add', this.value);
                    } else {
                        this.$emit('edit', this.value);
                    }

                    location.reload()

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
                
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.value._links.self.href))
                    }

                    this.editMode = false;
                    this.isDeleted = true;

                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            change(){
                this.$emit('input', this.value);
            },
            async enter(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links['/enter'].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeEnter();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openEnter() {
                this.enterDiagram = true;
            },
            closeEnter() {
                this.enterDiagram = false;
            },
            async modify(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links['/modify'].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeModify();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openModify() {
                this.modifyDiagram = true;
            },
            closeModify() {
                this.modifyDiagram = false;
            },
            async delete() {
                try {
                    if(!this.offline) {
                        await axios.delete(axios.fixUrl(this.value._links['delete'].href))
                    }

                    this.editMode = false;
                    this.isDelete = true;
                    
                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
        },
    }
</script>

