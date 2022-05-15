# Getting Started
To pull the configurations from the config files, send the following requests:

### From App1 config file
`curl --location --request GET 'localhost:8088/app1/default'`

```aidl
{
   "name":"app1",
   "profiles":[
      "default"
   ],
   "label":null,
   "version":null,
   "state":null,
   "propertySources":[
      {
         "name":"classpath:/config/app1.properties",
         "source":{
            "	greeting":"hello"
         }
      }
   ]
}
```
### From App2 config file
`curl --location --request GET 'localhost:8088/app2/default'`

```aidl
{
   "name":"app2",
   "profiles":[
      "default"
   ],
   "label":null,
   "version":null,
   "state":null,
   "propertySources":[
      {
         "name":"classpath:/config/app2.properties",
         "source":{
            "greeting":"bonjour"
         }
      }
   ]
}
```
### From App3 config file
`curl --location --request GET 'localhost:8088/app3/default'`

```aidl
{
   "name":"app3",
   "profiles":[
      "default"
   ],
   "label":null,
   "version":null,
   "state":null,
   "propertySources":[
      {
         "name":"classpath:/config/app3.properties",
         "source":{
            "greeting":"hola"
         }
      }
   ]
}
```
