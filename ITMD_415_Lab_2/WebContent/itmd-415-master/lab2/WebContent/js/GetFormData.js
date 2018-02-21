var elems = {'name':'#name', 'ssn':'#ssn', 'zip':'#zip', 'email':'#email', 'street':'#street', 'city':'#city', 'state':'#state'};

var problemsID = '#problems ol';

var invisLi = '<li class="hidden"></li>';

var buttonSubmit = "buttonSubmit";

$('document').ready(function()
{

    console.log('Doc is ready!');

});

log = console.log;

/*******************************************************************************
 * For all elements in <code>elems</code>, this will remove a class
 * <code>c</code>, which is by default <code>'invalid'</code>.
 */
function resetValidity(elems, c='invalid')
{
  Object.keys(elems).forEach(key => {
    $(elems[key]).removeClass(c);
  });
}

/*******************************************************************************
 * @returns Whether or not <code>str</code> is between (by default) 4-50
 *          characters.
 */
function validateString(str, bot=4, top=50)
{
    return (str.length >= bot && str.length <= top); // between bot and top
}

/*******************************************************************************
 * @returns Whether or not <code>ssn</code> is a valid Social Security number.
 */
function validateSSN(ssn, len=9)
{
    var s = ssn.replace(/[^0-9]/g, ''); // delete all non-numbers

    return (s.length >= len); // if it's 9 or more long
}



$('#sign-up').on('submit', function(e)
{ // someone wants to submit    
    resetValidity(elems);
    
    $(problemsID).empty();
    
    var valid = true;

    // validate name
    if (validateString($(elems['name']).val(), 4, 50))
    {
	log('Name OK!');
	$(problemsID).append(invisLi);
    }
    else
    {
	log('Name BAD!');
	valid = false;
	$(elems['name']).addClass('invalid');
	$(problemsID).append(('<li><a href="'+elems['name']+'">Name must be between 4 and 50 letters!</a></li>'));
    }

    // validate SSN
    if(validateSSN($('#ssn').val()))
    {
	log('SSN OK!');
	$(problemsID).append(invisLi);
    }
    else
    {
	log('SSN BAD!');
	valid = false;
	$(elems['ssn']).addClass('invalid');
	$(problemsID).append(('<li><a href="'+elems['ssn']+'">SSN is invalid!</a></li>'));
    }
    
    // skip zip code
    if(true)
    {
	log('Skipping zipcode...');
	$(problemsID).append(invisLi);
    }
    else
    {
	log('Zipcode BAD!');
	valid = false;
	$(elems['zip']).addClass('invalid');
	$(problemsID).append(('<li><a href="'+elems['zip']+'">Zip is somehow invalid! true != true! AAAAAA!!! GOD HELP US ALL!</a></li>'));
    }
    
    // skip email
    if(true)
    {
	log('Skipping email...');
	$(problemsID).append(invisLi);
    }
    else
    {
	log('Email BAD!');
	valid = false;
	$(elems['email']).addClass('invalid');
	$(problemsID).append(('<li><a href="'+elems['email']+'">Email is somehow invalid! true != true! AAAAAA!!! GOD HELP US ALL!</a></li>'));
    }
    
    
    // validate street
    if(validateString($(elems['street']).val(), 4, 50))
    {
	log('Street OK!');
	$(problemsID).append(invisLi);
    }
    else
    {
	log('Street BAD!');
	valid = false;
	$(elems['street']).addClass('invalid');
	$(problemsID).append(('<li><a href="'+elems['street']+'">Street must be between 4 and 50 characters!</a></li>'));
    }
    
    // validate city
    if(validateString($(elems['city']).val(), 3, 50))
    {
	log('City OK!');
	$(problemsID).append(invisLi);	
    }
    else
    {
	log('City BAD!');
        valid = false;
	$(elems['city']).addClass('invalid');
	$(problemsID).append(('<li><a href="'+elems['city']+'">City must be between 3 and 50 letters!</a></li>'));
    }
    
    // skip state
    if(true)
    {
	log('Skipping state...');
	$(problemsID).append(invisLi);
    }
    else
    {
	log('State BAD!');
	valid = false;
	$(elems['state']).addClass('invalid');
	$(problemsID).append(('<li><a href="'+elems['state']+'">State is somehow invalid! true != true! AAAAAA!!! GOD HELP US ALL!</a></li>'));
    }

    
    if(valid)
    {
      $('#problems').addClass('hidden');
      
      var thanks = ('<p>Thank you, ' + $('#name').val() + '.</p>');
            
      $('#sign-up').append(thanks);      
    }
    else
    {
      e.preventDefault();
      
      $('#problems').removeClass('hidden');
    }

});