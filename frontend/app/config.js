function config($routeProvider)
{
    var examResolver = {
        examId: function($route) {
            return $route.current.params.examId;
        }
    };

    $routeProvider
        .when('/',{
            template:'<addquestion name="siva"></addquestion>'
        })
        .when('/choseqs',{
            template:'<choosequestion></choosequestion>'
        })
        .when('/test', { template: '<exams></exams>' })
        .when('/exam/:examId', { template: '<addquestion test="$resolve.examId"></addquestion>', resolve: examResolver });

// http://fear.com/exam/6

}
