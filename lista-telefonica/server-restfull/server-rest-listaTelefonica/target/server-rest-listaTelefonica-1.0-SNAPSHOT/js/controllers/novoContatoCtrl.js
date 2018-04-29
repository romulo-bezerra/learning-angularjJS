angular.module("listaTelefonica").controller("novoContatoCtrl", function ($scope, contatosAPI, $location, operadoras) {
   
    $scope.operadoras = operadoras.data;
    
    $scope.addContato = function (contato) {
        contatosAPI.saveContato(contato).then(function (response) {
            delete $scope.contato;
            $scope.contatoForm.$setPristine();
            $scope.contatos.push(angular.copy(response.data));
        }, function (error) {
            console.log(error, 'Não foi possível salvar os dados');
        });
        $location.path("/contatos");
        $location.path("/contatos");
    };
});
