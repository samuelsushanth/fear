function ChoiceController(choiceService, $route) {
    var vm = this;


    vm.$onInit = $onInit;
    vm.newChoice = newChoice;
    vm.refreshChoices = refreshChoices;

    function $onInit() {
        //vm.choices ={"id":33,"text":"q1"};
        vm.choices= [];

        vm.examId = $route.current.params.eexamId;
        vm.questionId = $route.current.params.questionId;
        refreshChoices();
    }

    function refreshChoices() {
        return choiceService.list( vm.examId, vm.questionId).then(function refreshedchoices(response) {
            vm.choices = response.data;
        });
    }
    //to create new choices
    function newChoice()
    {
       /* //questionService.get();
        if(!vm.choicename)
            return;
        if(vm.choices.indexOf(vm.choicename)==-1)
        {

            // questionsService.create(vm.questionname);
            //vm.questions.push(vm.questionname);
            refreshQuestions();
            vm.choicename ="";
        }
        else{
            return;
        }*/
    }
}