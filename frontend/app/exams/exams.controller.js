function ExamsController() {
    var vm = this;


    vm.$onInit = $onInit;
    vm.newExam = newExam;

    function $onInit() {
       vm.examlist=[];
        //call list of exams from backend and store in examlist

    }

    //to create new exam
    function newExam()
    {
        //choiceService.update(vm.question, vm.choices, vm.answer).then(vm.refreshF())
    }

}