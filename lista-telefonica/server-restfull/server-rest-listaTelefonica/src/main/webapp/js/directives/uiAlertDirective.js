angular.module("listaTelefonica").directive("uiAlert", function () {
    return {
        templateUrl: "view/alert.html",
        restrict: "AE", //restrita ao atributo - apenas servirá como atributo ex: <div ui-alert></div>
                //restrict: "A" //restrita ao atributo - apenas servirá como atributo ex: <div ui-alert></div>
                //restrict: "E" //restrita ao elemento - apenas servirá como elemento ex: <ui-alert></ui-alert>
                //restrict: "AE" //restrita ao atributo e ao elemento
                //restrict: "C" //restrita a classe
                //restrict: "M" //restrita ao comentário
        scope: {
            title: "@"
            //message: "="
        },
        transclude: true
    };
});