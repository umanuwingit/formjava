the textarea element
const textarea = document.getElementById('myTextarea');

// Get the form element
const form = document.getElementById('myForm');

// Listen for the form submit event
form.addEventListener('submit', function(event) {
  // Prevent the default form submission
  event.preventDefault();

  // Get the textarea value
  const textareaValue = textarea.value;
  console.log(textareaValue)
  alert("You have inputed: " + textareaValue);
  output = document.createElement("p");
  output.textContent = textareaValue;
  document.body.appendChild(output);
/*
  // Create a new XMLHttpRequest object
  const xhr = new XMLHttpRequest();

  // Set the request method and URL
  xhr.open('POST', './index.html');

  // Set the request headers
  xhr.setRequestHeader('Content-Type', 'application/json');

  // Set the request body
  const requestBody = { text: textareaValue };
  xhr.send(JSON.stringify(requestBody));

  // Handle the response
  xhr.addEventListener('load', function() {
    if (xhr.status === 200) {
      console.log('Data sent successfully');
    } else {
      console.log('Error sending data');
    }
  });
*/
});