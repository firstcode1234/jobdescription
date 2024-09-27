<template>
    <v-card outlined>
        <v-card-title>
            Delete
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <String label="Jobname" v-model="value.jobname" :editMode="editMode"/>
            <String label="JobDescription" v-model="value.jobDescription" :editMode="editMode"/>
            <String label="Qualifications" v-model="value.qualifications" :editMode="editMode"/>
            <String label="Education" v-model="value.education" :editMode="editMode"/>
            <String label="CompletionEducation" v-model="value.completionEducation" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="delete"
            >
                Delete
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'DeleteCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.jobname = '';
            this.value.jobDescription = '';
            this.value.qualifications = '';
            this.value.education = '';
            this.value.completionEducation = '';
        },
        watch: {
        },
        methods: {
            delete() {
                this.$emit('delete', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

