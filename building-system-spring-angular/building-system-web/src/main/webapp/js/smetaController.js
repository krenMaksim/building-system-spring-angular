(function () {
    'use strict';

    BUILDING_SYS_APP.controller("smetaCtrl", function ($scope, appService) {
        $scope.smeta = appService.getSmetaRecords();
    });
}());
