function ExamsController() {
    var vm = this;


    vm.$onInit = $onInit;
    vm.newExam = newExam;

    function $onInit() {
       vm.exams=["asddsa","dsasd"];
        //call list of exams from backend and store in examlist

    }

    //to create new exam
    function newExam()
    {
        //examService.get();
        if(!vm.examname)
            return;
        if(vm.exams.indexOf(vm.examname)==-1)
        {

            vm.exams.push(vm.examname);
            vm.examname ="";
        }
        else{
            return;
        }
    }

}