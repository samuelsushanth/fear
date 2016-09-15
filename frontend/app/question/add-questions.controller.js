function ExamsController(examsService) {
    var vm = this;


    vm.$onInit = $onInit;
    vm.newQuestion = newQuestion;
    vm.refreshQuestions = refreshQuestions;

    function $onInit() {
        vm.questions ={"id":33,"text":"q1"};
        refreshQuestions();

    }
    function refreshQuestions() {
        return examsService.list().then(function refreshedquestions(response) {
            vm.questions = response.data;
        });
    }
    //to create new exam
    function newQuestion()
    {
        //examService.get();
        if(!vm.questionname)
            return;
        if(vm.exams.indexOf(vm.questionname)==-1)
        {
            examsService.create(vm.questionname);
            //vm.exams.push(vm.questionname);
            refreshQuestions();
            vm.questionname ="";
        }
        else{
            return;
        }
    }

}