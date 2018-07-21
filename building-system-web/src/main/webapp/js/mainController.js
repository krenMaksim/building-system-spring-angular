;
(function () {
    'use strict';

    BUILDING_SYS_APP.controller("mainCtrl", function ($scope, $location, $translate,appService) {

        $scope.templateUrl = {
            magazineTableHeader: SERVER_PART_URL + '/template/magazineTableHeader.html',
            caption: SERVER_PART_URL + '/template/caption.html',
            nameBuilding: SERVER_PART_URL + '/template/nameBuilding.html',
            redactionRecord: SERVER_PART_URL + '/redaction-record.html',
            header: SERVER_PART_URL + '/template/header.html'
        };

        $scope.user = appService.getValidUser();

        $scope.changeLanguage = function (langKey) {
            $translate.use(langKey);
        };

        $scope.changePath = function (newPath) {
            $location.path(newPath);
        };

        $scope.$on('$locationChangeSuccess', function (event) {
            let currentUrl = $location.url();

            switch (currentUrl) {
                case PAGE_URL.ADD_RECORD:
                    $scope.tableHeader = "REC_NEW_RECORD";
                    $scope.buttonHeader = "REC_SAVE_RECORD";
                    $scope.isDataBlock = true;
                    $scope.isInitialsBlock = true;
                    break;

                case PAGE_URL.REDACTION_RECORD:
                    $scope.tableHeader = "REC_UPDATED_RECORD";
                    $scope.buttonHeader = "REC_UPDATE_RECORD";
                    $scope.isDataBlock = false;
                    $scope.isInitialsBlock = false;
                    break;
            }
        });
    });
}());
