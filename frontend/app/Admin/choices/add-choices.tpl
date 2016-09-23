<div class="container" class="table-responsive">
    <table class="table table-bordered" >
        <thead>
        <tr class="info">
            <th style="text-align: center"> Question Name</th>
            <th> </th>
        </tr>
        </thead>
        <tr>
        <tr ng-repeat="choice in vm.choices" bgcolor="#d3d3d3">
            <td style="text-align: center"> {{choice.text}}</td>
            <td style="text-align: center"> <a class="btn btn-xs btn-default">Edit</a></td>
        </tr>
        <tr><td colspan="2">Add new choice</td></tr>
        </tbody>
    </table>
</div>