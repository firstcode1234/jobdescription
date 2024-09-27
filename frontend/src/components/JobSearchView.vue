<template>

    <v-data-table
        :headers="headers"
        :items="jobSearch"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'JobSearchView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "jobname", value: "jobname" },
            ],
            jobSearch : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/jobSearches'))

            temp.data._embedded.jobSearches.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.jobSearch = temp.data._embedded.jobSearches;
        },
        methods: {
        }
    }
</script>

