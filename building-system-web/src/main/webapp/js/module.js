;
(function () {
    'use strict';
    window.BASE_URL = '//localhost:8080/building-system/';
    window.SERVER_PART_URL = '/building-system';
    //window.SERVER_PART_URL = '';

    window.PAGE_URL = {
        MAGAZINE: "/magazine",
        SMETA: "/smeta",
        ADD_RECORD: "/add-record",
        REDACTION_RECORD: "/redaction-record"
    };

    window.AJAX_URL = {
        SMETA_REST: BASE_URL + "smeta-rest",
        MAGAZINE_REST: BASE_URL + "magazine-rest",
        USER_REST: BASE_URL + "all-users-rest",
        NEW_RECORD_REST: BASE_URL + "add-new-record-rest",
        REDACTION_RECORD_REST: BASE_URL + "redaction-record-rest",
        VALID_USER_REST: BASE_URL + "valid-user-rest"
    };

    window.BUILDING_SYS_APP = angular.module("BuildingSysApp", ["ngRoute", "ngCookies", "pascalprecht.translate"]);

    BUILDING_SYS_APP.config(function ($routeProvider, $locationProvider) {

        //$locationProvider.html5Mode(true);

        $routeProvider.when(PAGE_URL.SMETA, {
            templateUrl: SERVER_PART_URL+"/smeta.html",
            controller: "smetaCtrl"
        });

        $routeProvider.when(PAGE_URL.ADD_RECORD, {
            templateUrl: SERVER_PART_URL+"/add-record.html",
            controller: "addRecordCtrl"
        });

        $routeProvider.when(PAGE_URL.REDACTION_RECORD, {
            templateUrl: SERVER_PART_URL+"/redaction-record.html",
            controller: "redactionRecordCtrl"
        });

        $routeProvider.otherwise({
        	templateUrl: SERVER_PART_URL+"/magazine.html",
            controller: "magazineCtrl"
        });
    });

    BUILDING_SYS_APP.config(['$translateProvider', function ($translateProvider) {
        $translateProvider.useStaticFilesLoader({
            files: [
                {
                    prefix: 'data/header-locale-',
                    suffix: '.json'
                },
                {
                    prefix: 'data/smeta-locale-',
                    suffix: '.json'
                },
                {
                    prefix: 'data/magazine-locale-',
                    suffix: '.json'
                },
                {
                    prefix: 'data/record-locale-',
                    suffix: '.json'
                }
            ]
        });
        $translateProvider.preferredLanguage('ru');
    }]);
}());
