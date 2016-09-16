
<form class="text-center">

    <input type="text" ng-model="vm.questionname" title="asd" required placeholder="Enter the question">
    <button type="button" ng-click="vm.newQuestion()">Create Question</button>
</form><br />
<div class="container" class="table-responsive">
    <table class="table table-bordered" >
        <thead>
        <tr class="info">
            <th style="text-align: center"> Question Name</th>
            <th> </th>
        </tr>
        </thead>
        <tbody>
        asdafad
        <tr ng-repeat="questions in vm.questions" bgcolor="#d3d3d3">
            <td style="text-align: center"> {{questions}}</td>
            <td style="text-align: center"> <a class="btn btn-xs btn-default" href="#/question/{{questions.questionId}}">+Choice</a></td>


    </table>
</div>
