// Define the thickness of the plywood
double thickness = 6.35; // Z dimension (0.25 inches)

// Create the base cube
CSG base = new Cube(	
    355.6, // X dimension (14 inches)
    76.2,  // Y dimension (3 inches)
    thickness // Z dimension (0.25 inches)
).toCSG(); // Convert from the geometry to an object we can work with

// Move the cube up by half its thickness
base = base.movez(thickness / 2);

// Create the first cylinder (existing one)
CSG simpleSyntax1 = new Cylinder(28.575, thickness).toCSG(); // Create a cylinder with a radius of 28.575 and height of 6.35

// Position the first cylinder where you want it to cut out from the cube
simpleSyntax1 = simpleSyntax1.move(133.3754, 0, 0); // Move 133.3754 units in X direction, adjust as needed

// Create the second cylinder
CSG simpleSyntax2 = new Cylinder(6.35, thickness).toCSG(); // Adjust the radius as needed for the second hole
simpleSyntax2 = simpleSyntax2.move(-10.3886, 0, 0); // Position the second cylinder at the desired location

// Create the third cylinder
CSG simpleSyntax3 = new Cylinder(16, thickness).toCSG(); // Adjust the radius as needed for the third hole
simpleSyntax3 = simpleSyntax3.move(-154.15, 0, 0); // Position the third cylinder at the desired location

// Subtract the cylinders from the cube
CSG cutout = base.difference(simpleSyntax1).difference(simpleSyntax2).difference(simpleSyntax3);

// Return the object with the cutouts
return cutout;
