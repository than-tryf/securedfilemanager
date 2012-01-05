window.onload = addHoverToDatatableRows;

function addHoverToDatatableRows() {
    var trs = document.getElementById('resourcesForm:resourcesDatagrid').getElementsByTagName('tbody')[0]
        .getElementsByTagName('tr');
    for (var i = 0; i < trs.length; i++) {
        trs[i].onmouseover = new Function("this.bgColor='#EFF2F7'");
        trs[i].onmouseout = new Function("this.bgColor='#ffffff'");
    }
}