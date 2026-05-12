const BASE_URL = 'http://localhost:8080';
const patientForm = document.getElementById('patientForm');
const patientTable = document.getElementById('patientTable');

// read
async function fetchPatients() {
    try {
        const res = await fetch(`${BASE_URL}/patients`);
        const patients = await res.json();
        patientTable.innerHTML = patients.map(patient => `
            <tr>
                <td>${patient.id}</td>
                <td>${patient.firstName}</td>
                <td>${patient.lastName}</td>
                <td>${patient.age}</td>
                <td>${patient.gender}</td>
                <td>${patient.previousMedId}</td>
                <td>${patient.chiefComplaint}</td>
                <td>${patient.diagnosedIllness}</td>
                <td>${patient.prescribedMedId}</td>
                <td>
                    <button class="edit-btn" onclick="prepareEdit(${patient.id}, '${patient.firstName}', '${patient.lastName}', ${patient.age}, '${patient.gender}', '${patient.previousMedId}', '${patient.chiefComplaint}', '${patient.diagnosedIllness}', '${patient.prescribedMedId}')">Edit</button>
                    <button class="delete-btn" onclick="deletePatient(${patient.id})">Delete</button>
                </td>
            </tr>
        `).join('');
    } catch (err) {
        console.error("Failed to load patients:", err);
    }
}

// create and update
patientForm.onsubmit = async (e) => {
    e.preventDefault();
    
    const id = document.getElementById('patientId').value;
    const patientPayload = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        age: parseInt(document.getElementById('age').value),
        gender: document.getElementById('gender').value,
        previousMedId: document.getElementById('previousMedId').value,
        chiefComplaint: document.getElementById('chiefComplaint').value,
        diagnosedIllness: document.getElementById('diagnosedIllness').value,
        prescribedMedId: document.getElementById('prescribedMedId').value
    };

    const url = id ? `${BASE_URL}/update/${id}` : `${BASE_URL}/save`;
    const method = id ? 'PUT' : 'POST';

    await fetch(url, {
        method: method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(patientPayload)
    });

    patientForm.reset();
    document.getElementById('patientId').value = '';
    fetchPatients();
};

// delete
async function deletePatient(id) {
    if (confirm('Are you sure?')) {
        await fetch(`${BASE_URL}/delete/${id}`, { method: 'DELETE' });
        fetchPatients();
    }
}

// edit helper
function prepareEdit(id, fname, lname, age, gender, prevmedId, ccomplaint, dillness, presmedId) {
    document.getElementById('patientId').value = id;
    document.getElementById('firstName').value = fname;
    document.getElementById('lastName').value = lname;
    document.getElementById('age').value = age;
    document.getElementById('gender').value = gender;
    document.getElementById('previousMedId').value = prevmedId;
    document.getElementById('chiefComplaint').value = ccomplaint;
    document.getElementById('diagnosedIllness').value = dillness;
    document.getElementById('prescribedMedId').value = presmedId;
    
}

fetchPatients();