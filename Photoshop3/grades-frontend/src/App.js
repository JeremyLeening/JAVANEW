import React, { Component } from 'react';
import './info.css';


class App extends Component {

	constructor(props) {
		super(props);
		this.state = { openings: [], products: []};
	}

  async componentDidMount() {
    fetch('http://localhost:8080/openings')
      .then(response => response.json())
      .then(data =>  {
        this.setState({openings : data});
    })
    fetch('http://localhost:8080/products')
      .then(response => response.json())
      .then(data =>  {
        this.setState({products : data});
    })

  }

  render() {
    return (

      <div>
        <div class="text">
          <h1>
            Welcome to the photoshop store webapp
          </h1>
        </div>
        <div class= "container">
          <table id= "table">
          <thead>
            <tr>
               <th>Day</th>
               <th>Opening Time</th>
               <th>Closing Time</th>
            </tr>
            </thead>
            <tbody>
              {
                this.state.openings.map((opening, index) =>  
                       <tr key={index}>
                          <td>{opening.dayName}</td>
                          <td>{opening.openingTime}</td>
                          <td>{opening.closingTime}</td>
                        </tr>
                  )
              }
              </tbody>
        </table>        
        </div>
        <div class="container">
         <table id= "table">
          <thead>
              <tr>
                 <th>ID</th>
                 <th>Product Name</th>
                 <th>Price</th>
                 <th>Work Hours</th>
              </tr>
          </thead>
          <tbody>
              {
                this.state.products.map((product, index) =>  
                       <tr key={index}>
                          <td>{product.productId}</td>
                          <td>{product.productName}</td>
                          <td>{product.productPrice}</td>
                          <td>{product.workingHours}</td>
                        </tr>
                        
                  )
              }
              </tbody>
         </table>
        </div>
      </div>
    );
  }
}

export default App;