#### get All Users
`curl -s http://localhost:8080/topjava/rest/admin/users`

#### get Users 100001
`curl -s http://localhost:8080/topjava/rest/admin/users/100001`

#### get All Meals
`curl -s http://localhost:8080/topjava/rest/profile/meals`

#### get Meals 100003
`curl -s http://localhost:8080/topjava/rest/profile/meals/100003`

#### delete Meals
`curl -s -X DELETE http://localhost:8080/topjava/rest/profile/meals/100003`

#### filter Meals
`curl -s "http://localhost:8080/topjava/rest/profile/meals/filter?startDate=2020-01-30&startTime=13:00:00&endDate=2020-01-31&endTime=20:00:00"`
