(function() {
    'use strict';

    BUILDING_SYS_APP.controller('magazineCtrl', function($scope, appService) {
        $scope.magazine = appService.getMagazineRecords();

        $scope.correction = "MAG_SHOW_CORRECTION";
        $scope.surnameSet = new Set();
        $scope.dateWith;
        $scope.dateOn;

        $scope.changeSurnameSet = function(value) {
            let set = $scope.surnameSet;

            if (set.has(value)) {
                set.delete(value);
            } else {
                set.add(value);
            }
        };

        $scope.changeButtonLabel = function() {
            if ($scope.correction === "MAG_SHOW_CORRECTION") {
                $scope.correction = "MAG_HIDE_CORRECTION";
            } else {
                $scope.correction = "MAG_SHOW_CORRECTION";
            }
        };

        $scope.filterRecords = function(record) {
            let isDateCorrect = appService.isDateBelongedInterval(record.date, $scope.dateWith, $scope.dateOn);
            let isSurnameCorrect = appService.isSurnameBelongedInterval(record.surnameInitials, $scope.surnameSet);

            return isDateCorrect && isSurnameCorrect;
        };

        $scope.goToRedactionPage = function(selectedRecord) {
            //  Varable 'selectedRecord' create in parent scope to see in redactionRecordController.
            $scope.$parent.selectedRecord = selectedRecord;
            $scope.changePath(PAGE_URL.REDACTION_RECORD);
        };
    });

}());
