this is choice-form!
<br>
{{vm.choices}}

<form ng-submit="vm.choiceWasSubmitted()">
    <input type="text" ng-model="vm.choiceText">
    <button>submit choice</button>
</form>
{{vm.errortext}}