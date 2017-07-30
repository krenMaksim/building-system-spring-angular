;
(function() {
    'use strict';

    BUILDING_SYS_APP.controller("redactionRecordCtrl", function($scope, appService) {

        $scope.updatedRecord = Object.assign({}, $scope.selectedRecord);

        $scope.smetaMap = appService.getSmetaMap();
        $scope.smeta = appService.getSmetaRecords();
        $scope.users = appService.getUserRecords();

        // FOR! to correctly would be chosen select
        $scope.updatedRecord.idSmeta = $scope.updatedRecord.idSmeta + '';
        $scope.selectedDate = new Date($scope.updatedRecord.date);

        $scope.getRestSmeta = function(idSmeta) {
            let map = $scope.smetaMap;

            if (map.size === 0) {
                return null;
            }

            if (!map.has(idSmeta)) {
                return null;
            }

            return map.get(idSmeta).rest;
        };

        $scope.safeData = function() {
            $scope.updatedRecord.authorId = $scope.user.id;
            if ($scope.updatedRecord.ppSmeta === undefined) {
                $scope.updatedRecord.ppSmeta = $scope.smetaMap.get($scope.updatedRecord.idSmeta).pp;
            }

            $scope.responseReport = appService.safeUpdatedRecord($scope.updatedRecord);
        };

        $scope.$watch("selectedDate", function(newDate) {
            $scope.updatedRecord.date = appService.makeStringFromDate(newDate);
        });

        $scope.$watch("updatedRecord.idSmeta", function(newId) {
            let map = $scope.smetaMap;

            if (map.has(newId)) {
                let smetaObject = map.get(newId);
                $scope.updatedRecord.obosnovanie = smetaObject.naimenovanie;
                $scope.updatedRecord.edIzm = smetaObject.edIzm;
                $scope.updatedRecord.ppSmeta = smetaObject.pp;
                $scope.smetaRest = smetaObject.rest;
            }
        });

        $scope.$watch("updatedRecord.surnameInitials", function(newSurname) {
            let usersArray = $scope.users;

            if (usersArray === undefined) {
                return;
            }          
         
            for (let i = 0; i < Object.keys(usersArray).length; i++) {
                let userInitials = usersArray[i].surnameInitials;
                if (newSurname === userInitials) {
                    $scope.updatedRecord.role = usersArray[i].role;
                    $scope.updatedRecord.userId = usersArray[i].id;
                    break;
                }
            }
        });        

        $scope.$watch("responseReport[0]", function(newValue) {
            if (newValue === "Old record was changed") {
                $scope.changePath(PAGE_URL.MAGAZINE);
            }
        });
    });
}());
