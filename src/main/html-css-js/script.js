const BASE_URL = 'http://localhost:8080';
const userForm = document.getElementById('userForm');
const userTable = document.getElementById('userTable');

// read
async function fetchUsers() {
    try {
        const res = await fetch(`${BASE_URL}/users`);
        const users = await res.json();
        userTable.innerHTML = users.map(user => `
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.occupation}</td>
                <td>${user.age}</td>
                <td>
                    <button class="edit-btn" onclick="prepareEdit(${user.id}, '${user.firstName}', '${user.lastName}', '${user.occupation}', ${user.age})">Edit</button>
                    <button class="delete-btn" onclick="deleteUser(${user.id})">Delete</button>
                </td>
            </tr>
        `).join('');
    } catch (err) {
        console.error("Failed to load users:", err);
    }
}

// create and update
userForm.onsubmit = async (e) => {
    e.preventDefault();
    
    const id = document.getElementById('userId').value;
    const userPayload = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        occupation: document.getElementById('occupation').value,
        age: parseInt(document.getElementById('age').value)
    };

    const url = id ? `${BASE_URL}/update/${id}` : `${BASE_URL}/save`;
    const method = id ? 'PUT' : 'POST';

    await fetch(url, {
        method: method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(userPayload)
    });

    userForm.reset();
    document.getElementById('userId').value = '';
    fetchUsers();
};

// delete
async function deleteUser(id) {
    if (confirm('Are you sure?')) {
        await fetch(`${BASE_URL}/delete/${id}`, { method: 'DELETE' });
        fetchUsers();
    }
}

// edit helper
function prepareEdit(id, fname, lname, occ, age) {
    document.getElementById('userId').value = id;
    document.getElementById('firstName').value = fname;
    document.getElementById('lastName').value = lname;
    document.getElementById('occupation').value = occ;
    document.getElementById('age').value = age;
}

fetchUsers();