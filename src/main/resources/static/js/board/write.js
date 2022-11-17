alert('dd')
function getwrite(){

    let info = {
        btitle : document.querySelector('.btitle').value ,
        bcontent : document.querySelector('.bcontent').value
    }

    $.ajax({
        url : "/board/getwrite",
        type : "post",
        data : JSON.stringify( info ) ,
        contentType : "application/json",
        success : function(re) { alert(re) }
    })
}