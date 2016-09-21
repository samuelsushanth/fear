function QuestionsController(questionsService, $route) {
    var vm = this;


    vm.$onInit = $onInit;
    vm.newQuestion = newQuestion;
    vm.refreshQuestions = refreshQuestions;

    function $onInit() {
        //vm.questions ={"id":33,"text":"q1"};
        //alert(vm.exams);
        refreshQuestions();
        console.log($route.current.params.examId);
        vm.xamId = $route.current.params.examId;
        console.log(vm.xamId);

    }

    function refreshQuestions() {
        return questionsService.list().then(function refreshedquestions(response) {
            vm.questions = response.data;
        });
    }
    //to create new questions
    function newQuestion()
    {
        //questionService.get();
        if(!vm.questionname)
            return;
        if(vm.questions.indexOf(vm.questionname)==-1)
        {

           questionsService.create(vm.questionname);
            //vm.questions.push(vm.questionname);
            refreshQuestions();
            vm.questionname ="";
        }
        else{
            return;
        }
    }

}