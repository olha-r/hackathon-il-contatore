let res = document.querySelector('.quantity');
result = parseInt(res.value,10);

let plus = document.querySelector('.plus');
let moins = document.querySelector('.moins');

    // prendre en compte la modification du nombre au clavier
    // res.addEventListener('blur', function() {
    //    result = document.querySelector('.quantity');
	// 		result = parseInt(result.value,10);
    //         // result.forEach(element=>{
    //         //     parseInt(element.value,10);
    //         // })
    // });
    
    // boutton +
    plus.addEventListener('click', function() {
        result = document.querySelector('.quantity');
	    result = parseInt(result.value,10);
      if(result >= 0 && result < 2){
       result++;
       document.querySelector('.quantity').value= result;
       }
    });
    
     // boutton -
      moins.addEventListener('click', function() {
      if(result > 0 && result <= 2){
       result--;
       document.querySelector('.quantity').value= result;
       }
    });
    
    