function checkRegister(form) {
    if (form.confirmPassword.value != form.password.value) {
        alert("确认密码必须与密码相同！");
        form.confirmPassword.value = "";
        form.confirmPassword.focus();
        return false;
    }
    return true;
}