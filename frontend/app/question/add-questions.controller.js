function QuestionsController(questionsService) {
    var vm = this;


    vm.$onInit = $onInit;
    vm.newQuestion = newQuestion;
    vm.refreshQuestions = refreshQuestions;

    function $onInit() {
        vm.questions ={"id":33,"text":"q1"};
        refreshQuestions();

    }
    function refreshQuestions() {
        return questionsService.list().then(function refreshedquestions(response) {
            vm.questions = response.data;
        });
    }
    //to create new question
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