# HW4_ppfirake
Repository for HW4


###Question 1

####String Usage
```
if (node.type == 'Literal' && typeof(node.value)=="string")
		{
			fileBuilder.Strings+=1;
		}
```

####ParameterCount
```
builder.ParameterCount = node.params.length;
```

####PackageComplexity
```
			if (node.name == 'require')
		{
			fileBuilder.ImportCount+=1;
		}
```


####Returns: 
```
traverseWithParents(node, function (child)
			{
				if(child.type=='ReturnStatement')
				{
					builder.ReturnCount+=1;
				}
```

####AllConditions: 
```
if(node.type=='BinaryExpression')
		{
			fileBuilder.Allconditions+=1;
		}
```

###Q2

####SimpleCyclomaticComplexity: 
```
this.SimpleCyclomaticComplexity=1;
traverseWithParents(node, function (child)
			{
				if (isDecision(child)) {
					builder.SimpleCyclomaticComplexity += 1;
				}
			});
```

####MaxMessageChains: 
```
traverseWithParents(node, function(child){
				if (child.type === 'MemberExpression') {
					var tempmsglength = 0;
					traverseWithParents(child, function(child2){
						if (child2.type === 'MemberExpression') {
							traverseWithParents(child2, function(child3){
								if (child3.type === 'Literal') {
									tempmsglength -=1;
								}
							});
							tempmsglength +=1;
						} else if (child2.type === 'CallExpression') {
							tempmsglength +=1;
						}
					});
					chains.push(tempmsglength);
				}
			});
			builder.MaxMessageChains = Math.max.apply(Math, chains);
```

###Bonus

###MaxConditions:
```
traverseWithParents(node, function(child){
				if(isIfCondition(child)) {
					traverseWithParents(child, function(grandchild){
						if (grandchild.type == 'BinaryExpression') {
							builder.MaxConditions+=1;
						}
					});
				}
			});
```

###MaxNestingDepth: 
```
  traverseWithParents(node, function (child) {
					if (isDecision(child)) {

						traverseWithParents(child, function (child2) {
							if (isDecision(child2)) {
								tempmaxdepth += 1;
							}
						});
						
						tempmaxdepth = tempmaxdepth - minus;
						minus = 0;
						if (tempmaxdepth > builder.MaxNestingDepth) {
							builder.MaxNestingDepth = tempmaxdepth;
						}
					}
					tempmaxdepth = 0;
				});
```


