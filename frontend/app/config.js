function config($routeProvider)
{
    $routeProvider
        .when('/',{
            template:'<addquestion name="siva"></addquestion>'
        })
        .when('/xam',{
            template:'<exams> </exams>'
        })
        //.when('/exam/:xamId', { template: '<addquestion test="$resolve.examId"></addquestion>', resolve: examResolver })
        .when('/xam/:examId/question', { template:'<questions></questions>' });

    console.log($routeProvider);
// http://fear.com/exam/6

}