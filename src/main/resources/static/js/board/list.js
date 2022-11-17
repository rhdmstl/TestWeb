alert('목록')

blist();

function blist(){

    $.ajax({
        url : "/board/setlist",
        type : "get",
        success : function(re){
            console.log(re)
            let html = '<tr> <th>번호</th> <th>제목</th> <td>내용</th> </tr>';
            console.log(html)
            re.forEach( m =>{
            html += '<tr> <td>'+m.bno+'</td> <td>'+m.btitle+'</td> <td>'+m.bcontent+'</td> </tr>'
            })
            document.querySelector('.mtable').innerHTML = html;
            console.log(html)
        }
    })
}