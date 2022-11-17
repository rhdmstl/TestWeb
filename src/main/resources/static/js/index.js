blist();
function getwrite(){
    let info = {
        btitle : document.querySelector('.btitle').value ,
        bcontent : document.querySelector('.bcontent').value
    }
    $.ajax({
        url : "/getwrite",
        type : "post",
        data : JSON.stringify( info ) ,
        contentType : "application/json",
        success : function(re) { alert(re); location.reload(); }
    })
}
function blist(){
    $.ajax({
        url : "/setlist",
        type : "get",
        success : function(re){
            let html = '<tr> <th>번호</th> <th>제목</th> <td>내용</th> </tr>';
            re.forEach( m =>{
            html += '<tr> <td>'+m.bno+'</td> <td>'+m.btitle+'</td> <td>'+m.bcontent+'</td> </tr>'
            })
            document.querySelector('.mtable').innerHTML = html;
        }
    })
}