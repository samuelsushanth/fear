this is choice-form!
<br>
{{vm}}
<form ng-submit="vm.choiceWasSubmitted()">
    <ul >
        <li style="border: 1px solid black; text-decoration: none" ng-repeat="x in vm.choices">{{x}} <span ng-click="vm.removeItem($index)" style="cursor:pointer;">x</span></li>
    </ul>
    <input type="text" ng-model="vm.choiceText">
    <button>submit choice</button>
</form>
{{vm.errortext}}