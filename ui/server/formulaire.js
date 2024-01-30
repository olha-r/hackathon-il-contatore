let quantities = document.querySelectorAll('.quantity');

quantities.forEach(function (res) {
    let result = parseInt(res.value, 10);
    let plus = res.nextElementSibling;
    let moins = res.previousElementSibling;

    // prendre en compte la modification du nombre au clavier
    res.addEventListener('blur', function () {
        result = parseInt(res.value, 10);
    });

    // boutton +
    plus.addEventListener('click', function () {
        if (result >= 0 && result < 2) {
            result++;
            res.value = result;
        }
    });

    // boutton -
    moins.addEventListener('click', function () {
        if (result > 0 && result <= 2) {
            result--;
            res.value = result;
        }
    });
});
