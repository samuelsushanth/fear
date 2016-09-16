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
        .when('/xam',{
            template:'<exams> </exams>'
        })
        .when('/exam/:xamId', { template: '<addquestion test="$resolve.examId"></addquestion>', resolve: examResolver })
        .when('/xam/:examId', {
            //template:'asdas<questions exam-id="$resolve.examId"></questions>',
            template: '<questions></questions>'
            //resolve: examResolver
        });

    console.log($routeProvider);
// http://fear.com/exam/6

}
