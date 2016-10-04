function authenticationInterceptor() {}

function config($routeProvider, $httpProvider)
{
    $routeProvider
        .when('/',{
            template:'<addquestion name="siva"></addquestion>'
        })
        .when('/register',{
            template:'<registration></registration>'
        })
        .when('/xam',{
            template:'<exams> </exams>'
        })
        //.when('/exam/:xamId', { template: '<addquestion test="$resolve.examId"></addquestion>', resolve: examResolver })
        .when('/xam/:examId/question', { template:'<questions></questions>' })
        .when('/xam/:eexamId/question/:questionId/choice', { template:'<choices></choices>' });

    console.log($routeProvider);
// http://fear.com/exam/6
    //$httpProvider.interceptors.push(authenticationInterceptor)

    //$httpProvider.defaults.headers.common['Authorization'] = 'Basic Y2hhcmFuOmNoYXJhbg==';
}