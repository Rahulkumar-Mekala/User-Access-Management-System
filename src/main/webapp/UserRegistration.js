const loginForm = document.getElementById('loginForm');

 loginForm.addEventListener('submit', (event) => {
    const role = loginForm.role.value;
    console.log('Role:', role);
});
