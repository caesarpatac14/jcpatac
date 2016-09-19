#include <stdio.h>
#include <math.h>
#include <stdbool.h>

typedef struct {
	int x;
	int y;
} Point;

typedef struct {
	Point upper_left;
	Point lower_right;
} Rectangle;

int distanceForLength(Point a, Point b) {
	return (sqrt((pow((b.x - a.x), 2)) + (pow((a.y - a.y), 2))));
}

int distanceForWidth(Point x, Point y) {
return (sqrt((pow((y.x - y.x), 2)) + (pow((y.y - x.y), 2))));	
}

int area(Rectangle r) {
	return ((distanceForLength(r.lower_right, r.upper_left)) * (distanceForWidth(r.lower_right, r.upper_left)));
}

Point center(Rectangle r) {
	int x = ((r.upper_left.x + r.lower_right.x) / 2);
	int y = ((r.upper_left.y + r.lower_right.y) / 2);
	return (Point) {x, y};
}

Rectangle translate(Rectangle r, int x, int y) {
	r.upper_left.x = (r.upper_left.x + x);
	r.upper_left.y = (r.upper_left.y + y);
	r.lower_right.x = (r.lower_right.x + x);
	r.lower_right.y = (r.lower_right.y + y);
	return (Rectangle) {r.upper_left, r.lower_right};
}

bool withinRectangle(Rectangle r, Point p) {
	return (p.x >= r.upper_left.x && p.x <= r.lower_right.x) && (p.y >= r.upper_left.y && p.y <= r.lower_right.y);
}

int main () {
	Point a = {1, 3};
	Point b = {5, 3};
	Rectangle r = {a, b};
	printf("%d\n", distanceForLength(a, b));
	printf("%d\n", distanceForWidth(a, b));
	printf("%d\n", area(r));
	return 0;
}