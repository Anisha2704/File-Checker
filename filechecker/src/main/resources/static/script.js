const fileInput = document.getElementById('fileInput');
const result = document.getElementById('result');
const hashInput = document.getElementById('hashInput');

document.getElementById('hashBtn').addEventListener('click', async () => {
    const file = fileInput.files[0];
    if (!file) return alert("Select a file first!");

    const formData = new FormData();
    formData.append('file', file);

    const res = await fetch('/api/hash', {
        method: 'POST',
        body: formData
    });
    const hash = await res.text();
    result.value = hash;
});

document.getElementById('compareBtn').addEventListener('click', async () => {
    const file = fileInput.files[0];
    const userHash = hashInput.value.trim();
    if (!file || !userHash) return alert("Select file and enter hash!");

    const formData = new FormData();
    formData.append('file', file);
    formData.append('hash', userHash);

    const res = await fetch('/api/compare', {
        method: 'POST',
        body: formData
    });
    const msg = await res.text();
    alert(msg);
});