
<form class="text-center">
    <input type="text" ng-model="vm.examname" title="asd" >
    <button type="button" ng-click="vm.newExam()">Create</button>
</form>
<div class="container" class="table-responsive">
<table class="table table-bordered" >
    <thead>
    <tr>
        <th> Exam Name</th>
        <th> </th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat="exams in vm.exams">
    <td> {{exams}}</td>
    <td> <a class="btn btn-xs btn-default" href="#/xam">+a</a></td>
    </tr>
    </tbody>
</table>
</div>
