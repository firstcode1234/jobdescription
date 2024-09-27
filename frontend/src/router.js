
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import AllDepartmentsJobdescriptionManager from "./components/listers/AllDepartmentsJobdescriptionCards"
import AllDepartmentsJobdescriptionDetail from "./components/listers/AllDepartmentsJobdescriptionDetail"

import InnovationStrategyDepartmentOrganizationManager from "./components/listers/InnovationStrategyDepartmentOrganizationCards"
import InnovationStrategyDepartmentOrganizationDetail from "./components/listers/InnovationStrategyDepartmentOrganizationDetail"

import PersonnelOfficeEmployeeManager from "./components/listers/PersonnelOfficeEmployeeCards"
import PersonnelOfficeEmployeeDetail from "./components/listers/PersonnelOfficeEmployeeDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/allDepartments/jobdescriptions',
                name: 'AllDepartmentsJobdescriptionManager',
                component: AllDepartmentsJobdescriptionManager
            },
            {
                path: '/allDepartments/jobdescriptions/:id',
                name: 'AllDepartmentsJobdescriptionDetail',
                component: AllDepartmentsJobdescriptionDetail
            },

            {
                path: '/innovationStrategyDepartments/organizations',
                name: 'InnovationStrategyDepartmentOrganizationManager',
                component: InnovationStrategyDepartmentOrganizationManager
            },
            {
                path: '/innovationStrategyDepartments/organizations/:id',
                name: 'InnovationStrategyDepartmentOrganizationDetail',
                component: InnovationStrategyDepartmentOrganizationDetail
            },

            {
                path: '/personnelOffices/employees',
                name: 'PersonnelOfficeEmployeeManager',
                component: PersonnelOfficeEmployeeManager
            },
            {
                path: '/personnelOffices/employees/:id',
                name: 'PersonnelOfficeEmployeeDetail',
                component: PersonnelOfficeEmployeeDetail
            },



    ]
})
