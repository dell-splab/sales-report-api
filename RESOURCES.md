
# Data Resources Dictionary

<details open>
<summary style="font-size:16pt">Clients</summary>
<br>

### **`clients/`**

<strong><span style="color:lightgreen">GET</span></strong> response:

```json
[
    {
        "id": 0,
        "name": "string",
        "email": "string"
    },
    ...
]
```

<strong><span style="color:blue">POST</span></strong> request body:

```json
{
    "name": "string",
    "email": "string"
}
```

### **`clients/{id}`**

<strong><span style="color:lightgreen">GET</span></strong> response:

```json
{
    "name": "string",
    "email": "string"
}
```

<strong><span style="color:violet">PUT</span></strong> request body (Only fields to be changed):

```json
{
    "name": "string"
}
```

### **`clients/count/`**

<strong><span style="color:lightgreen">GET</span></strong> response:
```json
{
    "count": 1
}
```

</details>

<details>
<summary style="font-size:16pt">Products</summary>
<br>

### **`products/`**

<strong><span style="color:lightgreen">GET</span></strong> response:

```json
[
    {
        "id": 0,
        "name": "string",
        "price": 0.0,
        "category": "string",
        "description": "string"
    },
    ...
]
```

<strong><span style="color:blue">POST</span></strong> request body:

```json
{
    "name": "string",
    "price": 0.0,
    "category": "string",
    "description": "string"
}
```

### **`products/{id}`**

<strong><span style="color:lightgreen">GET</span></strong> response:

```json
{
    "name": "string",
    "price": 0.0,
    "category": "string",
    "description": "string"
}
```

<strong><span style="color:violet">PUT</span></strong> request body (Only fields to be changed):

```json
{
    "price": 0.0
}
```

<strong><span style="color:red">DELETE</span></strong> response body on 200 status code:

```json
{
    "name": "string",
    "price": 0.0,
    "category": "string",
    "description": "string"
}
```

### **`products/count/`**

<strong><span style="color:lightgreen">GET</span></strong> response:

```json
{
    "count": 0
}
```

</details>

<details>
<summary style="font-size:16pt">Leads</summary>
<br>

### **`leads/`**

<strong><span style="color:lightgreen">GET</span></strong> response:

```json
[
    {
        "client_id": 0,
        "sales_page": "string",
        "timestamp": "string"
    },
    ...
]
```

<strong><span style="color:blue">POST</span></strong> request body:

```json
{
    "nome": "string",
    "email": "string",
    "category": "string"
}
```

### **`leads/{category}`**

<strong><span style="color:lightgreen">GET</span></strong> response:

```json
[
    {
        "client_id": 0,
        "timestamp": "string"
    },
    ...
]
```

</details>

<details>
<summary style="font-size:16pt">Opportunities</summary>
<br>

### **`opps/`**

<strong><span style="color:lightgreen">GET</span></strong> response:

```json
[
    {
        "client_id": 0,
        "sales_page": "string"
    },
    ...
]
```

### **`opps/count/`**

<strong><span style="color:lightgreen">GET</span></strong> response:

```json
{
    "count": 0
}
```

</details>

<details>
<summary style="font-size:16pt">Sales</summary>
<br>

### **`sales/`**

<strong><span style="color:lightgreen">GET</span></strong> response:

```json
[
    {
        "client_id": 0,
        "produt_id": 0,
        "timestamp": "string"
    },
    ...
]
```

<strong><span style="color:blue">POST</span></strong> request body:

```json
{
    "client_id": 0,
    "items": [
        {
            "product_id": 0,
            "price": 0.0
        }
    ]
}
```

### **`sales/count/`**

<strong><span style="color:lightgreen">GET</span></strong> response:

```json
{
    "count": 0
}
```

</details>