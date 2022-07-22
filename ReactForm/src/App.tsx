import React, { useState } from 'react';
import './App.css';

function App() {

 const [formData, setFormData] = useState({first: "", last: "", npi: "", address:"", telephone:"", email:""})

 // Webpage form is submitted by the press of the button, the function will takeover!
 const submit = (e: React.ChangeEvent<HTMLFormElement>) =>
 {  
    e.preventDefault();
    console.log(formData);

    // Here we can add the POST call to axios or request to sent data to the backend

  }

 // Value in the fields of the form changes, update will occur in the internal states variables.
 const onChange = (e: React.ChangeEvent<HTMLInputElement>) =>
 {  
    setFormData({...formData, [e.target.name]: e.target.value});
    console.log(e);
  }

  return (
    <div className="App">
      <header className="App-header">
       
      </header>
      <main>
        <div>

        </div>
        <div className="signUpForm">
          <form /*action="/signUp"*/ method='POST' onSubmit={submit} >
          <img  id="logo" src="https://www.availity.com/-/media/Images/Global/logo20.ashx?" className="App-logo" alt="logo" />
            <fieldset>
              <label>
                <p>First Name</p>
                <input  id="first" name="first" type="text" placeholder="Enter First Name" onChange={onChange} required/>
                <p>Last Name</p>
                <input  id="last" name="last" type="text" placeholder="Enter Last Name"  onChange={onChange} required/>
                <p>NPI number</p>
                <input id="npi" name="npi" type="number" placeholder="Enter your NPI Number"  onChange={onChange} required/>
                <p>Business Address</p>
                <input id="address" name="address" type="text" placeholder="Enter address" onChange={onChange} />
                <p>Telephone</p>
                <input   id="telephone" name="telephone" type="tel" placeholder="Enter Telephone" onChange={onChange} />
                <p>Email</p>
                <input  id="email" name="email"  type="email" placeholder="Enter email"  onChange={onChange} required/>
              </label>
            <button  type="submit" >Sign Up</button>
            </fieldset>  
          </form>
        </div>
      </main>
    </div>
  );
}

export default App;

