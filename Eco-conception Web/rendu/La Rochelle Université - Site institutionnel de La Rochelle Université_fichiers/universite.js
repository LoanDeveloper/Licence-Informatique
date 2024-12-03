 
  // Init WOW effect
  wow = new WOW(
        {
        boxClass:     'js--wow',      
        animateClass: 'js--animated', 
        offset:       -100,        
      }
  ).init();


  //Scrollbar.initAll();
 

jQuery(window).load(function(){


  var timer_animation;

  // Add Class when page is loaded
  jQuery('.page').addClass('page--loaded');
  
  if(jQuery(window).width()> 1190){
    // Init Sticky element
    jQuery(".js--sticky").stick_in_parent({
     offset_top : 160,
    });
  }
  

  jQuery('.sidebar__category__select').click(function(){

    jQuery('.sidebar__category__list').toggleClass('sidebar__category__list--open');
    jQuery('.sidebar__category__select').toggleClass('sidebar__category__select--open');
  });


  
  // Init Parallax & Sticky header
  initScrollEvents();

   // Init Slider Home Page
  initSlider();

  // Init Slider Actuality
  initActuality(true);

  // Init Slider Actuality
  initProfile(true);
  
   // Init Slider Agenda
  initAgenda(true);

  jQuery(window).resize(function(){
    
    jQuery('.page').addClass('no--transition');
    clearTimeout(timer_animation);
    timer_animation = setTimeout(function() {
       jQuery('.page').removeClass('no--transition');
    }, 500);


    adapatSlider();
     // Init Slider Actuality
    initActuality(false);

    // Init Slider Actuality
    initProfile(false);
    
     // Init Slider Agenda
    initAgenda(false);
  });

  initNavigation();

  // Init push mobile
  initPush();

});


/*************** NAVIGATION *****************/

function initNavigation(){
  
  /*  var typed = new Typed('.search__input', {
      strings: ["Que^1000 cherchez vous ^500 ? ","Tapez votre recherche"],
      loop: true,
      typeSpeed:50,
      backDelay:1e3,
      backSpeed :50
    });

    var typed2 = new Typed('.search__input__mobile', {
      strings: ["Que^1000 cherchez vous ^500 ? ","Tapez votre recherche"],
      loop: true,
      typeSpeed:50,
      backDelay:1e3,
      backSpeed :50
    });


    jQuery('.search__input,.search__input__mobile').on('click',function(){
      if(jQuery(this).hasClass('search__input--auto')){
        jQuery(this).val();
         typed.destroy();
         typed2.destroy();
         jQuery(this).removeClass('search__input--auto');
      }
    }); */

  
  jQuery('.menu-item-has-children').click(function(){
      
      var all_elements = jQuery('.menu-item-has-children').not(this);
      var active_elements = jQuery('.sub-menu-active .sub-menu');
      var element = jQuery(this);
      var display_mask = true;

      if(active_elements.length>0 && !jQuery(this).hasClass('sub-menu-active')){
         all_elements.removeClass("sub-menu-active");
         setTimeout(function(){
           element.toggleClass('sub-menu-active');
        },700);
        jQuery('.page__mask').addClass('page__mask--active');
      }
      else{
         element.toggleClass('sub-menu-active');
        if(element.hasClass('sub-menu-active')){
          jQuery('.page__mask').addClass('page__mask--active');
        }
        else{
          jQuery('.page__mask').removeClass('page__mask--active');
        }
      }
  }).on('click', '.sub-menu', function(e) {
      // clicked on descendant div
      e.stopPropagation();
  });;

   jQuery('.page__mask').click(function(){
      jQuery('.page__mask').removeClass('page__mask--active');
      jQuery('.menu-item-has-children').removeClass("sub-menu-active").removeClass("open");
   });

   jQuery('.header__burger').click(function(){

      jQuery('.header__navigation').toggleClass('header__navigation--active');
      jQuery(".header__search__mobile").removeClass('sub-menu-active');
   });

   jQuery('.header__search__mobile>a').click(function(){

      jQuery('.header__navigation').removeClass('header__navigation--active');
   });

   jQuery('.sidebar__button').on('click',function(){
    jQuery('.sidebar').toggleClass('sidebar--active');
   });

   jQuery('.btn_more_slider').on('click',function(){
    jQuery('.home_slider_right_top').toggleClass('active');
    jQuery('.menu-acces-rapides-container').toggleClass('sidebar--active');
    jQuery('.menu-direct-access-container').toggleClass('sidebar--active');
   });


   jQuery('.close_popup').on('click',function(){
    jQuery('.home_slider_bandeau_top').toggleClass('bar--close');
   });
}




/*************** PUSH OPEN *****************/

function initPush(){
  

  
  jQuery('.push__elements').click(function(){
      
      var all_elements = jQuery('.push__elements').not(this);
      var active_elements = jQuery('.sub-menu-active .push_open__sub-menu');
      var element = jQuery(this);
      var display_mask = true;

      if(active_elements.length>0 && !jQuery(this).hasClass('sub-menu-active')){
         all_elements.removeClass("sub-menu-active");
         setTimeout(function(){
           element.toggleClass('sub-menu-active');
        },700);
        jQuery('.page__mask').addClass('page__mask--active');
      }
      else{
         element.toggleClass('sub-menu-active');
        if(element.hasClass('sub-menu-active')){
          jQuery('.page__mask').addClass('page__mask--active');
      jQuery('.menu-item-has-children').removeClass("sub-menu-active").removeClass("open");
        }
        else{
          jQuery('.page__mask').removeClass('page__mask--active');
        }
      }
  }).on('click', '.sub-menu', function(e) {
      // clicked on descendant div
      e.stopPropagation();
  });;

   jQuery('.page__mask').click(function(){
      jQuery('.page__mask').removeClass('page__mask--active');
      jQuery('.push__elements').removeClass("sub-menu-active");
   });


   jQuery('.header__search__mobile>a').click(function(){

      jQuery('.header__navigation').removeClass('header__navigation--active');
   });
}







/*************** SCROLL EVENTS *****************/

function initScrollEvents(){
  
    window.requestAnimationFrame = window.requestAnimationFrame
   || window.mozRequestAnimationFrame
   || window.webkitRequestAnimationFrame
   || window.msRequestAnimationFrame
   || function(f){setTimeout(f, 1000/50)}
   
   
  var didScroll;
  var lastScrollTop = 0;
  var delta = 5;
  var navbarHeight = jQuery('header').outerHeight();
   
  var elmt = jQuery('.js--parallax');
   
  function checkScroll(){
    var scrolltop = window.pageYOffset // get number of pixels document has scrolled vertically 
    jQuery(elmt).css({top:  (-scrolltop * .08)+200  + 'px' });// move bubble1 at 20% of scroll rate
    
    hasScrolled();
  
  }
  
  function hasScrolled() {
      var st = jQuery(this).scrollTop();
      
      if(st>140){
        jQuery('.header').addClass('header--stick');
      }
      else{
         jQuery('.header').removeClass('header--stick');
      }

      // Make sure they scroll more than delta
      if(Math.abs(lastScrollTop - st) <= delta)
          return;
      
      // If they scrolled down and are past the navbar, add class .nav-up.
      // This is necessary so you never see what is "behind" the navbar.
      if (st > lastScrollTop && st > navbarHeight){
          // Scroll Down
          //jQuery('.header').removeClass('header--down').addClass('header--up');
      } else {
          // Scroll Up
          if(st + jQuery(window).height() < jQuery(document).height()) {
              //jQuery('.header').removeClass('header--up').addClass('header--down');
          }
      }
      
      lastScrollTop = st;
  }
  
   window.addEventListener('scroll', function(){ // on page scroll
   requestAnimationFrame(checkScroll) // call parallaxbubbles() on next available screen paint
  }, false);
}


/*************** HOME SLIDE *****************/

var slider_interval = false;
var slider_auto     = true;
var slider_cpt      = 0;
var slider_working  = false;

function initSlider(){
  var container_width = jQuery('.slider__container').width();
  var slide_count = jQuery('.slider__oblic .slider__image').length;
  jQuery('.slider__images').css({width: slide_count*container_width});
  jQuery('.slider__container').attr('data-current-slide',1);
  slider_interval = setInterval(function(){ changeSlider('next',false) } ,5000);
}

function adapatSlider(){
  var container_width = jQuery('.slider__container').width();
  var slide_count = jQuery('.slider__oblic .slider__image').length;
  var current_slide = parseInt(jQuery('.slider__container').attr('data-current-slide'));

  jQuery('.slider__images').css({width: slide_count*container_width});

  slider_auto = false;
  slider_cpt = 0;
  jQuery('.slider__images--half,.slider__images--full').addClass('slider--notransition');
  jQuery('.slider__images--half').css({'transform':'translateX(-'+ container_width*(current_slide -1 ) + 'px) skew(30deg)'});
  jQuery('.slider__images--full').css({'transform':'translateX(-'+ container_width*(current_slide -1 ) + 'px)'});
  setTimeout(function(){
    jQuery('.slider__images--half,.slider__images--full').removeClass('slider--notransition');
  },100);

}

function changeSlider(direction,manual){
  var container_width = jQuery('.slider__container').width();
  var slide_count = parseInt(jQuery('.slider__container').attr('data-count-slide'));
  var current_slide = parseInt(jQuery('.slider__container').attr('data-current-slide'));
  var next_slide  = direction == 'next' ? current_slide+1 : current_slide-1;
  
  if(manual){
    slider_auto = false;
    slider_cpt = 0;
  }
  else if(!manual && !slider_auto) {
    if(slider_cpt==2){
      slider_auto=true;
      slider_cpt=0;
    }
    slider_cpt++;
  }

  if( (slider_auto || manual) && !slider_working && !(current_slide==1 && direction=='previous' )  ){
      slider_working = true;
      jQuery('.slider__images--half').css({'transform':'translateX(-'+ container_width*(next_slide -1 ) + 'px) skew(30deg)'});
      jQuery('.slider__images--full').css({'transform':'translateX(-'+ container_width*(next_slide -1 ) + 'px)'});
      
      if(next_slide == 1){
        next_slide = slide_count+1;
        setTimeout(function(){
          jQuery('.slider__images--half,.slider__images--full').addClass('slider--notransition');
          jQuery('.slider__images--half').css({'transform':'translateX(-'+ container_width*(slide_count) + 'px) skew(30deg)'});
          jQuery('.slider__images--full').css({'transform':'translateX(-'+ container_width*(slide_count) + 'px)'});
          setTimeout(function(){
            jQuery('.slider__images--half,.slider__images--full').removeClass('slider--notransition');
            slider_working = false;
          },100);
          jQuery('.slider__container').attr('data-current-slide',next_slide);
        },2000);
      }

      if(next_slide == (slide_count * 2  )){
        next_slide = slide_count;
        setTimeout(function(){
          jQuery('.slider__images--half,.slider__images--full').addClass('slider--notransition');
          jQuery('.slider__images--half').css({'transform':'translateX(-'+ container_width*(slide_count-1) + 'px) skew(30deg)'});
          jQuery('.slider__images--full').css({'transform':'translateX(-'+ container_width*(slide_count-1) + 'px)'});
          setTimeout(function(){
            jQuery('.slider__images--half,.slider__images--full').removeClass('slider--notransition');
            slider_working = false;
          },100);
          jQuery('.slider__container').attr('data-current-slide',next_slide);
          
          
        },2000);
      }
      else{
        setTimeout(function(){
          slider_working = false;
        },2000);
        jQuery('.slider__container').attr('data-current-slide',next_slide);
      }
      
  }
}


/*************** ACTUALITY SLIDE *****************/

function initActuality(first){
  var item_width = jQuery('.actuality__text').width();
  var slide_count = jQuery('.actuality__slide .actuality__text__item').length;
  jQuery('.actuality__slide').css({width: slide_count*item_width});
  jQuery('.actuality__slide').attr('data-current-slide',1);
  
  if(first)
  {
    jQuery('.actuality__slide').attr('data-current-slide',1);
    jQuery('.actuality__nav__left a').addClass('disable');
    jQuery('.actuality__container').swipe( {
      swipe:function(event, direction, distance, duration, fingerCount, fingerData) {
        if(direction=='left'){
          changeActuality('next',true);
        }
        else if(direction=='right'){
           changeActuality('previous',true);
        }
      }
     });
    
  }  
  else{
    var item_width      = jQuery('.actuality__text__item').width();
    var current_slide   = parseInt(jQuery('.actuality__slide').attr('data-current-slide'));
    jQuery('.actuality__slide').css({'margin-left':'-'+ ( ((item_width) * (current_slide -1 )) - 25 ) + 'px'});
  }
}

function changeActuality(direction,manual){
  var item_width      = jQuery('.actuality__text__item').width();
  var slide_count     = parseInt(jQuery('.actuality__slide').attr('data-count-slide'));
  var current_slide   = parseInt(jQuery('.actuality__slide').attr('data-current-slide'));
  var next_slide      = direction == 'next' ? current_slide+1 : current_slide-1;
  
  
 
  if(!(current_slide==1 && direction=='previous' )  && !(current_slide==slide_count && direction=='next' ) ){
      
      jQuery('.actuality__slide').css({'margin-left': - ( (item_width * ( next_slide - 1 )) - 10 ) + 'px'});
      jQuery('.actuality__slide').attr('data-current-slide',next_slide);
      jQuery('.actuality__image__item').removeClass('actuality__image__item--active');
      jQuery('#actuality__image__'+next_slide).addClass('actuality__image__item--active');
      if(next_slide == 1){
        jQuery('.actuality__nav__left a').addClass('disable');
      }
      else{
        jQuery('.actuality__nav__left a').removeClass('disable');
      }
      if(next_slide == slide_count ){
        jQuery('.actuality__nav__right a').addClass('disable');
      }
      else{
        jQuery('.actuality__nav__right a').removeClass('disable');
      }
      
  }
}

/*************** PROFILE SLIDE *****************/

function initProfile(first){
  var item_width = jQuery('.profile__item').width();
  var slide_count = jQuery('.profile__container .profile__item').length;
  jQuery('.profile__slide').css({width: slide_count*item_width});
  
  if(first)
  {
     jQuery('.profile__slide').attr('data-current-slide',1);
     jQuery('.profile__nav__left a').addClass('disable');
     jQuery('.profile__container').swipe( {
      swipe:function(event, direction, distance, duration, fingerCount, fingerData) {
        if(direction=='left'){
          changeProfile('next',true);
        }
        else if(direction=='right'){
           changeProfile('previous',true);
        }
      }
      });
  }  
  else{
    var item_width      = jQuery('.profile__item').width();;
    var current_slide   = parseInt(jQuery('.profile__slide').attr('data-current-slide'));
    jQuery('.profile__slide').css({'margin-left': - ( (item_width * ( current_slide - 1 )) - (200 * (current_slide-1)) ) + 'px'});
  }
}

function changeProfile(direction,manual){
  var item_width      = jQuery('.profile__item').width();
  var slide_count     = parseInt(jQuery('.profile__slide').attr('data-count-slide'));
  var current_slide   = parseInt(jQuery('.profile__slide').attr('data-current-slide'));
  var next_slide      = direction == 'next' ? current_slide+1 : current_slide-1;
   
  var displayed_slide = jQuery(window).width() > 845 ? 3 : (jQuery(window).width() > 400 ? 2 : 1 ) ;

  var limit_slide=  slide_count - ( displayed_slide - 1 ) ;
  
  //var margin = jQuery('html').hasClass('shapes') ? 200 : 0;
  var margin = 200 ;
 
  if(!(current_slide==1 && direction=='previous' )  && !(current_slide==limit_slide && direction=='next' ) ){
	  var isIE = /(MSIE|Trident\/|Edge\/)/i.test(navigator.userAgent);
      
	  if (isIE) {
		  jQuery('.profile__slide').css({'margin-left': - ( (item_width * ( next_slide - 1 )) ) + 'px'});
	  } else {
          jQuery('.profile__slide').css({'margin-left': - ( (item_width * ( next_slide - 1 )) - (margin * (next_slide-1)) ) + 'px'});
	  }
      jQuery('.profile__slide').attr('data-current-slide',next_slide);
      
      if(next_slide == 1){
        jQuery('.profile__nav__left a').addClass('disable');
      }
      else{
        jQuery('.profile__nav__left a').removeClass('disable');
      }
      if(next_slide == limit_slide ){
        jQuery('.profile__nav__right a').addClass('disable');
      }
      else{
        jQuery('.profile__nav__right a').removeClass('disable');
      }
      
  }
}


/*************** AGENDA SLIDE *****************/

function initAgenda(first){
  var item_width = jQuery('.agenda__container').width();
  var slide_count = jQuery('.agenda__container .agenda__item').length;
  jQuery('.agenda__slide').css({width: slide_count*item_width});
 

  if(first)
  {
     jQuery('.agenda__slide').attr('data-current-slide',1);
     jQuery('.agenda__slide .agenda__item:nth-child(1)').addClass('agenda__item--active');
     jQuery('.agenda__nav__left a').addClass('disable');
     jQuery('.agenda__container').swipe( {
      swipe:function(event, direction, distance, duration, fingerCount, fingerData) {
        if(direction=='left'){
          changeAgenda('next',true);
        }
        else if(direction=='right'){
           changeAgenda('previous',true);
        }
      }
     });
  }  
  else{
    var item_width      = jQuery('.agenda__item').width();;
    var current_slide   = parseInt(jQuery('.agenda__slide').attr('data-current-slide'));
    jQuery('.agenda__slide').css({'margin-left': - ( (item_width * ( current_slide - 1 ))) + 'px'});
  }
}

function changeAgenda(direction,manual){
  var item_width      = jQuery('.agenda__item').width();
  var slide_count     = parseInt(jQuery('.agenda__slide').attr('data-count-slide'));
  var current_slide   = parseInt(jQuery('.agenda__slide').attr('data-current-slide'));
  var next_slide      = direction == 'next' ? current_slide+1 : current_slide-1;
  
  
 
  if(!(current_slide==1 && direction=='previous' )  && !(current_slide==slide_count && direction=='next' ) ){
      
      jQuery('.agenda__slide').css({'margin-left': - ( (item_width * ( next_slide - 1 ))) + 'px'});
      jQuery('.agenda__slide').attr('data-current-slide',next_slide);
       jQuery('.agenda__slide .agenda__item').removeClass('agenda__item--active');
      jQuery('.agenda__slide .agenda__item:nth-child('+(next_slide)+')').addClass('agenda__item--active');
      
      if(next_slide == 1){
        jQuery('.agenda__nav__left a').addClass('disable');
      }
      else{
        jQuery('.agenda__nav__left a').removeClass('disable');
      }
      if(next_slide == slide_count ){
        jQuery('.agenda__nav__right a').addClass('disable');
      }
      else{
        jQuery('.agenda__nav__right a').removeClass('disable');
      }
      
  }
}






























