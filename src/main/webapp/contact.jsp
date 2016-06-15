<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contact</title>
<link href="http://127.0.0.1:8080/ShopSite/resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<!--theme-style-->
<link href="http://127.0.0.1:8080/ShopSite/resources/css/mainstyle.css" rel="stylesheet"
	type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--fonts-->
<link
	href='http://fonts.useso.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<script src="http://127.0.0.1:8080/ShopSite/resources/js/jquery.min.js"></script>
<script src="http://127.0.0.1:8080/ShopSite/resources/js/jquery.easydropdown.js"></script>

<!--script-->
</head>
<body>
	<!--header-->
	<div class="header">
		<div class="top-header">
			<div class="container">
				<div class="top-header-left">
					<ul class="support">
						<li><a href="#"><label> </label></a></li>
						<li><a href="#">24x7 live<span class="live">
									support</span></a></li>
					</ul>
					<ul class="support">
						<li class="van"><a href="#"><label> </label></a></li>
						<li><a href="#">Free shipping <span class="live">on
									order over 500</span></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="top-header-right">
					<div class="down-top">

						<select tabindex="4" class="dropdown">
							<option value="" class="label" value="">English</option>
							<option value="1">Japanese</option>
							<option value="2">French</option>
							<option value="3">German</option>
						</select>
					</div>
					<div class="down-top top-down">

						<select tabindex="4" class="dropdown ">
							<option value="" class="label" value="">Currency :USD</option>
							<option value="1">Dollar</option>
							<option value="2">Euro</option>
						</select>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="http://127.0.0.1:8080/ShopSite/home.jsp"><img
							src="resources/imageslogo.png" alt=" " /></a>
					</div>
					<div class="search">
						<input type="text" value="" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '';}"> <input
							type="submit" value="SEARCH">

					</div>
					<div class="clearfix"></div>
				</div>
				<div class="header-bottom-right">
					<ul class="men-grid">
						<li><a href="http://127.0.0.1:8080/ShopSite/login.jsp"><span>
							</span>YOUR ACCOUNT</a></li>
						<li class="login"><a
							href="http://127.0.0.1:8080/ShopSite/login.jsp"><span>
							</span>LOGIN</a>|</li>
						<li class="cart"><a href="#"><span> </span>CART</a></li>
					</ul>
					<div class="sign-up-right">
						<a href="http://127.0.0.1:8080/ShopSite/register.jsp">SIGNUP</a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!---->
	<div class="container">

		<!---->
		<div class="main">
			<div class="reservation_top">
				<div class=" contact_right">
					<h3>Contact Form</h3>
					<div class="contact-form">
						<form method="post" action="contact-post.jsp">
							<input type="text" class="textbox" value="Name"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Name';}"> <input
								type="text" class="textbox" value="Email"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Email';}">
							<textarea value="Message" onfocus="this.value= '';"
								onblur="if (this.value == '') {this.value = 'Message';}">Message</textarea>
							<input type="submit" value="Send">
							<div class="clearfix"></div>
						</form>
						<address class="address">
							<p>
								9870 St Vincent Place, <br>Glasgow, DC 45 Fr 45.
							</p>
							<dl>
								<dt></dt>
								<dd>
									Freephone:<span> +1 800 254 2478</span>
								</dd>
								<dd>
									Telephone:<span> +1 800 547 5478</span>
								</dd>
								<dd>
									FAX: <span>+1 800 658 5784</span>
								</dd>
								<dd>
									E-mail:&nbsp; <a href="mailto@vintage.com">info(at)bigshop.com</a>
								</dd>
							</dl>
						</address>
					</div>
				</div>
			</div>
		</div>
		<div class="sub-cate">
			<div class=" top-nav rsidebar span_1_of_left">
				<h3 class="cate">CATEGORIES</h3>
				<ul class="menu">
					<li class="item1"><a href="#">Curabitur sapien<img
							class="arrow-img" src="resources/imagesarrow1.png" alt="" />
					</a>
						<ul class="cute">
							<li class="subitem1"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Cute
									Kittens </a></li>
							<li class="subitem2"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Strange
									Stuff </a></li>
							<li class="subitem3"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Automatic
									Fails </a></li>
						</ul></li>
					<li class="item2"><a href="#">Dignissim purus <img
							class="arrow-img " src="resources/imagesarrow1.png" alt="" /></a>
						<ul class="cute">
							<li class="subitem1"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Cute
									Kittens </a></li>
							<li class="subitem2"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Strange
									Stuff </a></li>
							<li class="subitem3"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Automatic
									Fails </a></li>
						</ul></li>
					<li class="item3"><a href="#">Ultrices id du<img
							class="arrow-img img-arrow" src="resources/imagesarrow1.png"
							alt="" />
					</a>
						<ul class="cute">
							<li class="subitem1"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Cute
									Kittens </a></li>
							<li class="subitem2"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Strange
									Stuff </a></li>
							<li class="subitem3"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Automatic
									Fails</a></li>
						</ul></li>
					<li class="item4"><a href="#">Cras iacaus rhone <img
							class="arrow-img img-left-arrow" src="resources/imagesarrow1.png"
							alt="" /></a>
						<ul class="cute">
							<li class="subitem1"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Cute
									Kittens </a></li>
							<li class="subitem2"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Strange
									Stuff </a></li>
							<li class="subitem3"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Automatic
									Fails </a></li>
						</ul></li>
					<li>
						<ul class="kid-menu">
							<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Tempus
									pretium</a></li>
							<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Dignissim
									neque</a></li>
							<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Ornared
									id aliquet</a></li>
						</ul>
					</li>
					<ul class="kid-menu ">
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Commodo
								sit</a></li>
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Urna
								ac tortor sc</a></li>
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Ornared
								id aliquet</a></li>
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Urna
								ac tortor sc</a></li>
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Eget
								nisi laoreet</a></li>
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Faciisis
								ornare</a></li>
						<li class="menu-kid-left"><a
							href="http://127.0.0.1:8080/ShopSite/contact.jsp">Contact us</a></li>
					</ul>

				</ul>
			</div>
			<!--initiate accordion-->
			<script type="text/javascript">
				$(function() {
					var menu_ul = $('.menu > li > ul'), menu_a = $('.menu > li > a');
					menu_ul.hide();
					menu_a.click(function(e) {
						e.preventDefault();
						if (!$(this).hasClass('active')) {
							menu_a.removeClass('active');
							menu_ul.filter(':visible').slideUp('normal');
							$(this).addClass('active').next().stop(true, true)
									.slideDown('normal');
						} else {
							$(this).removeClass('active');
							$(this).next().stop(true, true).slideUp('normal');
						}
					});

				});
			</script>
			<div class=" chain-grid menu-chain">
				<a href="http://127.0.0.1:8080/ShopSite/single.jsp"><img
					class="img-responsive chain" src="resources/imageswat.jpg" alt=" " /></a>
				<div class="grid-chain-bottom chain-watch">
					<span class="actual dolor-left-grid">300$</span> <span
						class="reducedfrom">500$</span>
					<h6>Lorem ipsum dolor</h6>
				</div>
			</div>
			<a class="view-all all-product"
				href="http://127.0.0.1:8080/ShopSite/product.jsp">VIEW ALL
				PRODUCTS<span> </span>
			</a>
		</div>
	</div>
	<!---->
	<div class="footer">
		<div class="footer-top">
			<div class="container">
				<div class="latter">
					<h6>NEWS-LATTER</h6>
					<div class="sub-left-right">
						<form>
							<input type="text" value="Enter email here"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Enter email here';}" />
							<input type="submit" value="SUBSCRIBE" />
						</form>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="latter-right">
					<p>FOLLOW US</p>
					<ul class="face-in-to">
						<li><a href="#"><span> </span></a></li>
						<li><a href="#"><span class="facebook-in"> </span></a></li>
						<div class="clearfix"></div>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="footer-bottom-cate">
					<h6>CATEGORIES</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Eget nisi laoreet</a></li>
						<li><a href="#">Faciisis ornare</a></li>
					</ul>
				</div>
				<div class="footer-bottom-cate bottom-grid-cat">
					<h6>FEATURE PROJECTS</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
					</ul>
				</div>
				<div class="footer-bottom-cate">
					<h6>TOP BRANDS</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Eget nisi laoreet</a></li>
						<li><a href="#">Faciisis ornare</a></li>
					</ul>
				</div>
				<div class="footer-bottom-cate cate-bottom">
					<h6>OUR ADDERSS</h6>
					<ul>
						<li>Aliquam metus dui.</li>
						<li>orci, ornareidquet</li>
						<li>ut,DUI.</li>
						<li>nisi, dignissim</li>
						<li>gravida at.</li>
						<li class="phone">PH : 6985792466</li>
						<li class="temp">
							<p class="footer-class">
								Copyright &copy; 2015.Company name All rights reserved.<a
									target="_blank" href="http://www.sucai888.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
							</p>
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>