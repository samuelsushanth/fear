function ChoiceFormController(choiceService) {
    var vm = this;

    vm.$onInit = $onInit;
    vm.choiceWasSubmitted = choiceWasSubmitted;
    vm.removeItem = removeItem;

    function $onInit() {
        vm.choices = ["Milk", "Bread"];
    }

    function choiceWasSubmitted() {
        console.log("A choice was submitted. The text of it is: " + vm.choiceText);

        vm.errortext = "";
        //vm.choices.push(vm.choiceText)

        if (!vm.choiceText) {
            return;
        }
        if (vm.choices.indexOf(vm.choiceText) == -1) {
            vm.choices.push(vm.choiceText);
            alert(vm.choices);
            vm.choiceText = "";
            vm.choiceList = "hyf";
            count++;
        } else {
            vm.errortext = "The choice is already in your list.";
            vm.choiceText = "";
        }
    }

    function removeItem(x){
            vm.errortext = "";
            vm.choices.splice(x, 1);
            count++;
        }

    // this is just for basic understanding
    /*function $onInit() {
        console.log("A new instance of ChoiceFormController has been created.")
        choiceService.list().then(function(response) {
            //console.log("got", response);
            vm.choices = response.data;
        })
    }*/
}