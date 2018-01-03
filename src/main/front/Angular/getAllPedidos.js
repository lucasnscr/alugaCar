                function listAllPedidos() {
                    $http({
                        method : 'GET',
                        url : 'http://localhost:8080/alugaCar/pedido/:id'
                    }).then(function successCallback(response) {
                        $scope.pedido = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }