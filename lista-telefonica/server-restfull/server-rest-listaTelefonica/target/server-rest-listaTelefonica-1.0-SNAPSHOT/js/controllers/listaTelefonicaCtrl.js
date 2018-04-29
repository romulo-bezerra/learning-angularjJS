angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, contatosAPI, contatos) {
    $scope.app = "Lista Telefonica";
    $scope.contatos = contatos.data;

    var carregarContatos = function () {
        contatosAPI.getContatos().then(function (response) {
            data = response.data;
            $scope.contatos = data;
        }, function (error) {
            $scope.error = "Não foi possível carregar os dados!";
            console.log(error, 'Não foi possível obter os dados');
        });
    };

    $scope.apagarContatos = function (contatos) {
        $scope.contatos = contatos.filter(function (contato) {
            if (contato.selecionado) {
                contatosAPI.removeContatos(contato).then(function (response) {
                    carregarContatos();
                }, function (error) {
                    console.log(error, 'Não foi possível excluir os dados');
                });
            }
            ;
        });
    };

    $scope.isContatosSelecionados = function (contatos) {
        return contatos.some(function (contato) {
            return contato.selecionado;
        });
    };

    $scope.ordenarPor = function (campo) {
        $scope.criterioDeOrdenacao = campo;
        $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
    };

    carregarContatos();

});
