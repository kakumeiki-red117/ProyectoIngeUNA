/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function pageLoad(){
}
        
function login(){
    var usuario = new Usuario(document.getElementById("ide").value,document.getElementById("passw").value,0);
    Proxy.userLogin(usuario,
        function(usuario){
            switch(usuario.tipo){
                case 0:
                    document.getElementById("ide").className += ' error';
                    break;
                case 1:
                    document.location = "/SGUC/LoginExitosoAdminU0.html";
                    break;
                case 2:
                    document.location = "/SGUC/LoginExitosoU1.html";
                    break;
                case 3:
                    document.location = "/SGUC/LoginExitosoU2.html";
                    break;
            }
        });
}
        
function check(e){
    if(e.className === 'input-txt error'){
        e.className = 'input-txt';
    }
}


