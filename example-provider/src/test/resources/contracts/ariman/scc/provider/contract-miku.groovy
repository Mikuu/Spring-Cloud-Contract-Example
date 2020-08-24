import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return miku's response"
    request{
        method GET()
        url("/information") {
            queryParameters {
                parameter("name", "Miku")
            }
        }
    }
    response {
        status 200

        headers {
            header 'Content-Type': 'application/json'
        }

        body '''\
        { "salary": 45000,
          "name": "Hatsune Miku",
          "nationality": "Japan",
          "contact": {
            "Email": "hatsune.miku@ariman.com",
            "Phone Number": "9090950"
            }
        }'''
        
    }
}