function config($routeProvider)
{
    var examResolver = {
        examId: function($route) {
            return $route.current.params.examId;
        }
    };

    $routeProvider
        .when('/',{
            template:'<choice-form name="siva"></choice-form>'
        })
        .when('/exam/:examId', { template: '<choice-form test="$resolve.examId"></choice-form>', resolve: examResolver });
// http://fear.com/exam/6

}
